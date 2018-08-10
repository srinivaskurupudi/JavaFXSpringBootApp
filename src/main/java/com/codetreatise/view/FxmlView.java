package com.codetreatise.view;

import java.util.ResourceBundle;

public enum FxmlView {

    COUNTRY {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("country.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/Country.fxml";
        }
    },
    GROUND {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("ground.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/Ground.fxml";
        }
    },
    PLAYERSCORE {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("player.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/PlayerScore.fxml";
        }
    },
    ADDPLAYER {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("addplayer.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/AddPlayer.fxml";
        }
    },
    ADDMATCH {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("addmatch.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/AddMatch.fxml";
        }
    },
    DASHBOARD {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("dashboard.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/Dashboard.fxml";
        }
    };
    
    public abstract String getTitle();
    public abstract String getFxmlFile();
    
    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    }

}
