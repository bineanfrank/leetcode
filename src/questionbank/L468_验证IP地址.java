package questionbank;

public class L468_验证IP地址 {

    public static void main(String[] args) {
        String res = new L468_验证IP地址().validIPAddress("00.0.0.0");
        System.out.println(res);

//        res = new L468_验证IP地址().validIPAddress("1e1.4.5.6");
//        System.out.println(res);
//
//        res = new L468_验证IP地址().validIPAddress("256.256.256.256");
//        System.out.println(res);
//
//        res = new L468_验证IP地址().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334");
//        System.out.println(res);
//
//        res = new L468_验证IP地址().validIPAddress("172.16.254.1");
//        System.out.println(res);
    }

    public String validIPAddress(String IP) {
        if (IP == null || IP.length() < 7) return "Neither";
        String[] ipv4 = IP.split("\\.", -1);
        if (ipv4.length == 4) {
            // 验证ipv4
            for (int i = 0; i < ipv4.length; i++) {
                try {
                    Integer number = Integer.parseInt(ipv4[i]);
                    int length = ipv4[i].length();
                    if (number < 0 ||
                            (number == 0 && length != 1) ||
                            (number > 0 && number < 10 && length != 1) ||
                            (number >= 10 && number < 100 && length != 2) ||
                            (number >= 100 && number <= 255 && length != 3) ||
                            (number > 255)) {
                        return "Neither";
                    }
                } catch (Exception e) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else {
            String[] ipv6 = IP.split(":", -1);
            if (ipv6.length == 8) {
                for (int i = 0; i < ipv6.length; i++) {
                    if (ipv6[i].length() <= 0 || ipv6[i].length() > 4) return "Neither";
                    try {
                        Integer.parseInt(ipv6[i], 16);
                    } catch (Exception e) {
                        return "Neither";
                    }
                }
                return "IPv6";
            }
        }
        return "Neither";
    }
}
