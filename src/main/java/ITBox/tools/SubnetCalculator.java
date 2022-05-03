package ITBox.tools;

import java.util.ArrayList;

public class SubnetCalculator {
    private String sClass;
    private ArrayList<Integer> sHosts;
    private String[][] ipRanges = new String[4][5];

    private boolean classful = false;

    private final int[] nearest = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536,
                                   131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608};

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
        int s1Seg;
        int s2Seg;
        int s3Seg = 0;
        int hostSeg = 0;
        String networkAddress = "";
        String firstHostAddress = "";
        String lastHostAddress = "";
        String broadcastAddress = "";
        String subnetMask;
        switch (sClass) {
            case "A": {
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
                    int j = 0;
                    while (i + 2 <= nearest[j]) {
                        j++;
                    }
                    //Converting the int segments into a whole dot separated address
                    networkAddress = s1Seg + "." + s2Seg + "." + s3Seg + "." + hostSeg;
                    hostSeg += 1;
                    firstHostAddress = s1Seg + "." + s2Seg + "." + s3Seg + "." + hostSeg;
                    hostSeg += nearest[j] - 2;
                    if (hostSeg >= 255) {
                        s3Seg = (int) (hostSeg + 1 / 256);
                        hostSeg = ((hostSeg + 1 / 256) - 1 - s3Seg) * 256;
                        if (s3Seg >= 255) {
                            s2Seg = (int) (s3Seg + 1 / 256);
                            s3Seg = ((s3Seg + 1 / 256) - 1 - s2Seg) * 256;
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

                    ipRanges[i][0] = networkAddress;
                    ipRanges[i][1] = firstHostAddress;
                    ipRanges[i][2] = lastHostAddress;
                    ipRanges[i][3] = broadcastAddress;
                    //ipRanges[i][4] = subnetMask;
                }
            }
            case "B": {
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
                    int j = 0;
                    while (i + 2 <= nearest[j]) {
                        j++;
                    }
                    //Converting the int segments into a whole dot separated address
                    networkAddress = s1Seg + "." + s2Seg + "." + s3Seg + "." + hostSeg;
                    hostSeg += 1;
                    firstHostAddress = s1Seg + "." + s2Seg + "." + s3Seg + "." + hostSeg;
                    hostSeg += nearest[j] - 2;
                    if (hostSeg >= 255) {
                        s3Seg = (int) (hostSeg + 1 / 256);
                        hostSeg = ((hostSeg + 1 / 256) - 1 - s3Seg) * 256;
                        if (s3Seg >= 255) {
                            s2Seg = (int) (s3Seg + 1 / 256);
                            s3Seg = ((s3Seg + 1 / 256) - 1 - s2Seg) * 256;
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

                    ipRanges[i][0] = networkAddress;
                    ipRanges[i][1] = firstHostAddress;
                    ipRanges[i][2] = lastHostAddress;
                    ipRanges[i][3] = broadcastAddress;
                    //ipRanges[i][4] = subnetMask;
                }
            }
            case "C": {
                //Setting the first two segments as they will never change in class C
                s1Seg = 192;
                s2Seg = 168;
                //"all that jazz" -adam
                int ii = 0;
                for (int i : sHosts) {
                    //Returns error value of -1 (Subnet Size too large)
                    if (i + 2 > 256) {
                        return (-1);
                    }
                    //Rounding up to the nearest square of two
                    int j = 23;
                    while (i + 2 <= nearest[j]) {
                        j--;
                    }
                    //Converting the int segments into a whole dot separated address
                    networkAddress = "" + s1Seg + "." + s2Seg + "." + s3Seg + "." + hostSeg;
                    hostSeg += 1;
                    firstHostAddress = s1Seg + "." + s2Seg + "." + s3Seg + "." + hostSeg;
                    hostSeg += nearest[j] - 2;
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
                    //ipRanges[ii][4] = subnetMask;
                    ii++;
                }
            }
        }
        return 0;
    }

    public void setClassful(boolean classful) {
        this.classful = classful;
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
