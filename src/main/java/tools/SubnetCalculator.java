package tools;

import java.util.ArrayList;

public class SubnetCalculator {
    private String sClass;
    private ArrayList<Integer> sHosts;
    private String[][] ipRanges;

    private final int[] nearest = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536,
                                   131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432,
                                   67108864, 134217728, 268435456, 536870912, 1073741824};
    private final String[] nearestSM = {"255.255.255.255", "255.255.255.254", "255.255.255.252", "255.255.255.248",
                                    "255.255.255.240", "255.255.255.224", "255.255.255.192", "255.255.255.128",
                                    "255.255.255.0", "255.255.254.0", "255.255.252.0", "255.255.248.0", "255.255.240.0",
                                    "255.255.224.0", "255.255.192.0", "255.255.128.0", "255.255.0.0", "255.254.0.0",
                                    "255.252.0.0", "255.248.0.0", "255.240.0.0", "255.224.0.0", "255.192.0.0",
                                    "255.128.0.0", "255.0.0.0", "254.0.0.0", "252.0.0.0", "248.0.0.0", "240.0.0.0",
                                    "224.0.0.0", "192.0.0.0"};

    /**
     * Calculates Subnets.
     * <p>
     * Used to find the IP address ranges for a customizable subnet
     *  @param  initClass The Network Class of choice in the form of a char, Must be CAPITALIZED.
     * @param  initHosts An ArrayList filled with the required number of Hosts in each subnet.
     */
    public SubnetCalculator(String initClass, ArrayList<Integer> initHosts) {
        sClass = initClass;
        sHosts = initHosts;
    }

    public int calculate() {
        int ii = 0;
        int s1Seg;
        int s2Seg;
        int s3Seg = 0;
        int hostSeg = 0;
        String networkAddress = "";
        String firstHostAddress = "";
        String lastHostAddress = "";
        String broadcastAddress = "";
        String subnetMask;
        ipRanges = new String[sHosts.size()][5];
        switch (sClass) {
            case "A":
                //Setting the first twos segments as they will either never change or start at a non-0 number
                s1Seg = 10;
                s2Seg = 0;
                //"all that jazz" -adam
                for (int i : sHosts) {
                    //Returns error value of -1 (Subnet Size too large)
                    if (i + 2 > 16777216) {
                        return (-1);
                    }
                    //Rounding up to the nearest square of two
                    int j = 30;
                    while (i + 2 <= nearest[j]) {
                        j--;
                    }
                    j++;
                    //hehe
                    //christmas
                    //Converting the int segments into a whole dot separated address
                    networkAddress = s1Seg + "." + s2Seg + "." + s3Seg + "." + hostSeg;
                    hostSeg += 1;
                    firstHostAddress = s1Seg + "." + s2Seg + "." + s3Seg + "." + hostSeg;
                    hostSeg += nearest[j] - 3;
                    if (hostSeg >= 256) {
                        s3Seg = (int) (hostSeg / 256);
                        double temp = ((hostSeg / 256.0) - s3Seg) * 256.0;
                        hostSeg = (int) (temp);
                        if (s3Seg >= 256) {
                            s2Seg = (int) ((s3Seg) / 256);
                            s3Seg = (int) (((s3Seg / 256.0) - (double) (s2Seg)) * 256.0);
                            if (s2Seg >= 255) {
                                return -1;
                            }
                        }
                    }
                    lastHostAddress = s1Seg + "." + s2Seg + "." + s3Seg + "." + hostSeg;
                    hostSeg += 1;
                    broadcastAddress = s1Seg + "." + s2Seg + "." + s3Seg + "." + hostSeg;
                    //Checking if the Host Segment is full and setting the s3Seg to the next one and resetting hostSeg
                    if (hostSeg == 255) {
                        hostSeg = 0;
                        s3Seg += 1;
                        if (s3Seg == 256) {
                            s2Seg += 1;
                            s3Seg = 0;
                        }
                    } else {
                        hostSeg += 1;
                    }

                    //Setting subnet

                    ipRanges[ii][0] = networkAddress;
                    ipRanges[ii][1] = firstHostAddress;
                    ipRanges[ii][2] = lastHostAddress;
                    ipRanges[ii][3] = broadcastAddress;
                    ipRanges[ii][4] = nearestSM[j];
                    ii++;
                }
                break;
            case "B":
                //Setting the first twos segments as they will either never change or start at a non-0 number
                s1Seg = 172;
                s2Seg = 16;
                //"all that jazz" -adam
                for (int i : sHosts) {
                    //Returns error value of -1 (Subnet Size too large)
                    if (i + 2 > 65536) {
                        return (-1);
                    }
                    //Rounding up to the nearest square of two
                    int j = 30;
                    while (i + 2 <= nearest[j]) {
                        j--;
                    }
                    j++;
                    //Converting the int segments into a whole dot separated address
                    networkAddress = s1Seg + "." + s2Seg + "." + s3Seg + "." + hostSeg;
                    hostSeg += 1;
                    firstHostAddress = s1Seg + "." + s2Seg + "." + s3Seg + "." + hostSeg;
                    hostSeg += nearest[j] - 3;
                    if (hostSeg >= 255) {
                        s3Seg = (int) (hostSeg / 256);
                        double temp = ((hostSeg / 256.0) - s3Seg) * 256.0;
                        hostSeg = (int) (temp);
                        if (s3Seg >= 255) {
                            s2Seg = (int) ((s3Seg) / 256);
                            s3Seg = ((s3Seg / 256) - s2Seg) * 256;
                            if (s2Seg >= 32) {
                                return -1;
                            }
                        }
                    }
                    lastHostAddress = s1Seg + "." + s2Seg + "." + s3Seg + "." + hostSeg;
                    hostSeg += 1;
                    broadcastAddress = s1Seg + "." + s2Seg + "." + s3Seg + "." + hostSeg;
                    //Checking if the Host Segment is full and setting the s3Seg to the next one and resetting hostSeg
                    if (hostSeg == 255) {
                        s3Seg += 1;
                        hostSeg = 0;
                        if (s3Seg == 255) {
                            s2Seg += 1;
                            s3Seg = 0;
                        }
                    } else {
                        hostSeg += 1;
                    }
                    //Setting subnet

                    ipRanges[ii][0] = networkAddress;
                    ipRanges[ii][1] = firstHostAddress;
                    ipRanges[ii][2] = lastHostAddress;
                    ipRanges[ii][3] = broadcastAddress;
                    ipRanges[ii][4] = nearestSM[j];
                    ii++;
                }
                break;
            case "C":
                //Setting the first two segments as they will never change in class C
                s1Seg = 192;
                s2Seg = 168;
                //"all that jazz" -adam
                for (int i : sHosts) {
                    //Returns error value of -1 (Subnet Size too large)
                    if (i + 2 > 256) {
                        return (-1);
                    }
                    //Rounding up to the nearest square of two
                    int j = 30;
                    while (i + 2 <= nearest[j]) {
                        j--;
                    }
                    j++;
                    //Converting the int segments into a whole dot separated address
                    networkAddress = "" + s1Seg + "." + s2Seg + "." + s3Seg + "." + hostSeg;
                    hostSeg += 1;
                    firstHostAddress = s1Seg + "." + s2Seg + "." + s3Seg + "." + hostSeg;
                    hostSeg += nearest[j] - 3;
                    lastHostAddress = s1Seg + "." + s2Seg + "." + s3Seg + "." + hostSeg;
                    hostSeg += 1;
                    broadcastAddress = s1Seg + "." + s2Seg + "." + s3Seg + "." + hostSeg;
                    //Checking if the Host Segment is full and setting the s3Seg to the next one and resetting hostSeg
                    if (hostSeg == 255) {
                        s3Seg += 1;
                        hostSeg = 0;
                    } else {
                        hostSeg += 1;
                    }
                    ipRanges[ii][0] = networkAddress;
                    ipRanges[ii][1] = firstHostAddress;
                    ipRanges[ii][2] = lastHostAddress;
                    ipRanges[ii][3] = broadcastAddress;
                    ipRanges[ii][4] = nearestSM[j];
                    ii++;
                }
                break;
        }
        return 0;
    }

    public String getSubnetClass(){
        return sClass;
    }

    public void setSubnetClass(String sClass) {
        this.sClass = sClass;
    }

    public ArrayList<Integer> getRequiredHosts() {
        return sHosts;
    }

    public void setRequiredHosts(ArrayList<Integer> sHosts) {
        this.sHosts = sHosts;
    }

    public String[][] getIpRanges() {
        return ipRanges;
    }
}
