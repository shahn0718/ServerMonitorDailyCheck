package com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.model;

public class MXmlServerInfo {
    /**
     * GW XML NAME
     *
     */
//    public static final String gwNode1 = "gw-node1";
//    public static final String gwNode2 = "gw-node2";
//    public static final String gwNode3 = "gw-node3";
//    public static final String gwNode4 = "gw-node4";
//    public static final String gwDevNode1 = "gw-dev-node1";
//    public static final String gwBackUp = "gw-backup";
//    public static final String gwArch5 = "gw-arch5";

    private MXmlServerInfo xmlServerInfo;

    public enum ServerXmlInfo {
        GWNODE_1("gw-node1","gwnode_1","4","42",null,null),
        GWNODE_2("gw-node2","gwnode_2","4","42",null,null),
        GWNODE_3("gw-node3","gwnode_3","4","42",null,null),
        GWNODE_4("gw-node4","gwnode_4","4","42",null,null),
        GWDEVNODE_1("gw-dev-node1","gwdevnode_1","4","42",null,null),
        GWBACKUP("gw-backup","gwbackup","4","42",null,null),
        GWARCH_5("gw-arch5","gwarch_5","4","42",null,null);

        /**
         * cpuUsage
         * memUsage
         * swapUsage
         * clustUsage
         *
         *
         */

        private String xmlServerName;
        private String xmlViewName;
        private String cpuUsage;
        private String memUsage;
        private String swapUsage;
        private String clustUsage;


        ServerXmlInfo(String xmlServerName, String xmlViewName, String cpuUsage, String memUsage, String swapUsage, String clustUsage){
            this.xmlServerName = xmlServerName;
            this.xmlViewName = xmlViewName;
            this.cpuUsage = cpuUsage;
            this.memUsage = memUsage;
            this.swapUsage = swapUsage;
            this.clustUsage = clustUsage;

        }

        public String getXmlServerName(){return xmlServerName;}
        public String getXmlViewName(){return xmlViewName;}

        public String getCpuUsage() {return cpuUsage;}
        public String getMemUsage(){return memUsage;}
        public String getSwapUsage(){return swapUsage;}
        public String getClustUsage(){return clustUsage;}

    }
}
