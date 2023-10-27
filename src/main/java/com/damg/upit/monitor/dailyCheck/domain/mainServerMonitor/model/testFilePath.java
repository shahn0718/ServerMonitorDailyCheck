package com.damg.upit.monitor.dailyCheck.domain.mainServerMonitor.model;

public class testFilePath {


    public enum filePath {

        GW_FILE_PATH("GW","C:\\ServerMonitorDailyCheck\\xmlGwFile"),
        ERP_FILE_PATH("ERP","C:\\ServerMonitorDailyCheck\\xmlErpFile");

        private String pathCd;
        private String pathResult;

        filePath(String pathCd, String pathResult){
            this.pathCd = pathCd;
            this.pathResult = pathResult;
        }

        public String getPathCd() {
            return pathCd;
        }
        public String getPathResult(){
            return pathResult;
        }

    }
}
