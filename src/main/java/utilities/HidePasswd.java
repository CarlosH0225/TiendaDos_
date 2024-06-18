package utilities;

public class HidePasswd {

    private String passw;
    private String hidePassw;

    public HidePasswd(String passw) {
        this.passw = passw;
        this.hidePassw = "";
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public String getHidePassw() {
        return hidePassw;
    }

    public void setHidePassw(String hidePassw) {
        this.hidePassw = hidePassw;
    }

    public void changeCharacter() {

        for (int i = 0; i < passw.length(); i++) {
            if ((passw.charAt(i) >= 'a' && passw.charAt(i) <= 'z') || (passw.charAt(i) >= '0' && passw.charAt(i) <= '9')) {
                hidePassw += '*';
            }
        }

    }

}
