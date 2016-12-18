package kh.com.kshrd.ipcam.entity.camera.CameraType.Impl;

import kh.com.kshrd.ipcam.entity.camera.CameraType.ICamCommand;
import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by rina on 12/18/16.
 */
public class Vivotek implements ICamCommand {


    private String host;
    private int port;
    private String user;
    private String pass;
    CloseableHttpClient httpclient;


    public Vivotek(){}

    public Vivotek(String host, int port, String user, String pass) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void configeHttpClient(){
        if (user != null && user.length() > 0) {
            CredentialsProvider credsProvider = new BasicCredentialsProvider();
            credsProvider.setCredentials(
                    new AuthScope(host, port),
                    new UsernamePasswordCredentials(user, pass));
            httpclient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
        }
        else
            httpclient = HttpClients.createDefault();
    }


    private HttpGet makeRequest(String move) {
        return new HttpGet(String.format("http://%s%s/cgi-bin/camctrl/camctrl.cgi?move=" + move, host, port == 80? "": String.format(":%d", port)));
    }


    @Override
    public boolean left(String left) {
        if(left.equalsIgnoreCase(left))
            return executeCommand("left","left");
        return false;
    }

    @Override
    public boolean right(String right) {
        if(right.equalsIgnoreCase("right"))
            return executeCommand("right","right");
        return false;
    }

    @Override
    public boolean up(String up) {
        if (up.equalsIgnoreCase(up))
            return executeCommand("up","up");
        return false;
    }

    @Override
    public boolean down(String down) {
        if(down.equalsIgnoreCase("down"))
            return executeCommand("down","down");
        return false;
    }

    @Override
    public boolean zoomIn(String zoomIn) {
        if (zoomIn.equalsIgnoreCase("tele"))
            return executeCommand("zoom in","tele");
        return false;
    }

    @Override
    public boolean zoomOut(String zoomOut) {
        if (zoomOut.equalsIgnoreCase("wide"))
            return executeCommand("wide","wide");
        return false;
    }

    @Override
    public boolean executeCommand(String msg, String command) {
        boolean rslt = false;
        HttpGet req = makeRequest(command);
        System.out.println(req);
        org.apache.http.entity.StringEntity ent = new org.apache.http.entity.StringEntity(msg, "UTF-8");
        try {

            CloseableHttpResponse response2 = httpclient.execute(req);

            try {
                HttpEntity entity2 = response2.getEntity();
                InputStreamReader isr = new InputStreamReader(entity2.getContent());
                BufferedReader br = new BufferedReader(isr);
                String l = br.readLine();
                while (l != null) {
                    System.out.println(l);
                    l = br.readLine();
                }
                rslt = (response2.getStatusLine().getStatusCode() >=200 &&
                        response2.getStatusLine().getStatusCode()< 300);
            } finally {
                response2.close();
            }
        } catch (Exception ex) {

        }

        return true;
    }
    @Override
    public  boolean stop(){
        return executeCommand("down","stop");
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String getPass() {
        return pass;
    }

    @Override
    public void setPass(String pass) {
        this.pass = pass;
    }

}
