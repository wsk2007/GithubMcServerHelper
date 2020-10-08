package com.wangshengkai.gmcs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

/**
 * @author wsk2007
 * 服务器配置文件
 */
public class Settings {
    /**
     * 服务端jar名称
     */
    private String serverJarName;
    /**
     * github用户名
     */
    private String githubUserName;
    /**
     * github邮箱
     */
    private String githubEmail;
    /**
     * 存档仓库名称
     */
    private String dataRepoName;
    /**
     * github ssh key
     * 不参与json序列化与反序列化
     */
    @Expose(serialize = false, deserialize = false)
    private String githubSSHKey;


    public String getServerJarName() {
        return serverJarName;
    }

    public void setServerJarName(String serverJarName) {
        this.serverJarName = serverJarName;
    }

    public String getGithubUserName() {
        return githubUserName;
    }

    public void setGithubUserName(String githubUserName) {
        this.githubUserName = githubUserName;
    }

    public String getGithubEmail() {
        return githubEmail;
    }

    public void setGithubEmail(String githubEmail) {
        this.githubEmail = githubEmail;
    }

    public String getDataRepoName() {
        return dataRepoName;
    }

    public void setDataRepoName(String dataRepoName) {
        this.dataRepoName = dataRepoName;
    }

    protected String getGithubSSHKey() {
        return githubSSHKey;
    }

    protected void setGithubSSHKey(String githubSSHKey) {
        this.githubSSHKey = githubSSHKey;
    }

    /**
     * 重写toSting方法为输出json数据
     * @return json data
     */
    @Override
    public String toString() {
        // 创建gson对象
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = builder.create();

        // 解析json
        return gson.toJson(this);
    }
}
