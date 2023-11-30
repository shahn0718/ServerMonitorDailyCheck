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
        GWNODE_1("gw-node1","gwnode_1"),
        GWNODE_2("gw-node2","gwnode_2"),
        GWNODE_3("gw-node3","gwnode_3"),
        GWNODE_4("gw-node4","gwnode_4"),
        GWDEVNODE_1("gw-dev-node1","gwdevnode_1"),
        GWBACKUP("gw-backup","gwbackup"),
        GWARCH_5("gw-arch5","gwarch_5");

        ServerXmlInfo(String xmlServerName, String xmlViewName){
            this.xmlServerName = xmlServerName;
            this.xmlViewName = xmlViewName;
        }

        private String xmlServerName;
        private String xmlViewName;

        public String getXmlServerName(){return xmlServerName;}
        public String getXmlViewName(){return xmlViewName;}
    }
}
