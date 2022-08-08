import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DHCP {

    static class DhcpServer {


        //记录当前ip占有情况
        //"VACANCY" 表示未被分配过
        //"<Mac_address>" 正在使用该地址的mac
        //"RELEASE" 表示已经分配过，但已经释放
        String[] ipVacancy = new String[256];
        final static String VANCANCY_STATE = "VACANCY";
        final static String RELEASE_STATE = "RELEASE";

        //记录Mac地址历史
        HashMap<String,Integer> macAddressRecentIp = new HashMap<>();


        DhcpServer() {
            // 初始化所有端口为空闲
            Arrays.fill(ipVacancy, VANCANCY_STATE);
        }

        private int availableIp(){
            int firstHasBeenDistributedNotOccupy = -1;

            //按照升序查找可用IP
            for (int i = 0; i < ipVacancy.length; i++) {
                    //记录第一个已经释放但未被占用的端口
                    if (firstHasBeenDistributedNotOccupy == -1 && ipVacancy[i].equals(RELEASE_STATE)  ){
                        firstHasBeenDistributedNotOccupy = i;
                    }

                    //如果有空余的直接返回i
                    if (ipVacancy[i].equals(VANCANCY_STATE)){
                        return i;
                    }
            }

            //如果没有空余的，则返回状态2的：表示已经分配过，但已经释放
            return firstHasBeenDistributedNotOccupy;
        }


        String request(String mac) {
            int distributeIp = -1;

            //如果Mac没有申请过
            if (!macAddressRecentIp.containsKey(mac)){
                //将mac地址分配到可用ip
                int availableIp = availableIp();
                macAddressRecentIp.put(mac,availableIp);
                //ip状态变为1：已经配过并占用
                ipVacancy[availableIp] = mac;

                return "192.168.0." + availableIp;

            }
            //如果申请过
            else {
                //如果对应的ip未被占用，直接分配
                if (ipVacancy[macAddressRecentIp.get(mac)].equals(RELEASE_STATE) ){
                    ipVacancy[macAddressRecentIp.get(mac)] = mac;
                    return "192.168.0." + macAddressRecentIp.get(mac);

                }
                //如果不为空,且已经被其他mac占用,需要寻找新的端口
                else if (!ipVacancy[macAddressRecentIp.get(mac)].equals(mac)){
                    //重新分配
                    //将mac地址分配到可用ip
                    int availableIp = availableIp();
                    macAddressRecentIp.put(mac,availableIp);
                    //ip状态变为已经配过并占用
                    ipVacancy[availableIp] = mac;

                    return "192.168.0." + availableIp;
                }
                else {
                    return "NA";
                }

            }

        }

        void release(String mac) {
            //查看是否分配过ip
            if (macAddressRecentIp.containsKey(mac)){
                //查看ip是否被这个mac占用
                if (ipVacancy[macAddressRecentIp.get(mac)].equals(mac)){
                    ipVacancy[macAddressRecentIp.get(mac)] = RELEASE_STATE;
                }
            }

        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        DhcpServer dhcpServer = new DhcpServer();
        int operationCnt = cin.nextInt();
        for (int i = 0; i < operationCnt; i++) {
            String[] operation = cin.next().split("=");
            if ("REQUEST".equals(operation[0])) {
                System.out.println(dhcpServer.request(operation[1]));
            } else {
                dhcpServer.release(operation[1]);
            }
        }
        cin.close();
    }
}
