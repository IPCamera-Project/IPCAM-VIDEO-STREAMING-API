package kh.com.kshrd.ipcam.entity.camera.CameraType;

/**
 * Created by rina on 12/18/16.
 */
public interface ICamCommand {
    boolean left(String left);
    boolean right(String right);
    boolean up(String up);
    boolean down(String down);
    boolean zoomIn(String zoomIn);
    boolean zoomOut(String zoomOut);
    boolean executeCommand(String msg,String command);
    boolean stop();
    void configeHttpClient();

    public String getHost();

    public void setHost(String host);

    public int getPort();

    public void setPort(int port);

    public String getUser();

    public void setUser(String user);

    public String getPass();

    public void setPass(String pass);
}
