package com.wangshengkai.gmcs;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author wsk2007
 * 本类负责读取与写入配置文件
 */
public class SettingsHelper {
    /**
     * 配置文件对象
     */
    private Settings settings;

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    /**
     * 写入配置文件
     * @param path 写入路径
     */
    public void saveSettings(String path){
        // 创建写入器
        FileWriter writer = new FileWriter(path);

        // 写入文件
        writer.write(settings.toString());
    }

    /**
     * 读取配置文件
     * @param path 读取路径
     */
    public void loadSettings(String path){
        // 创建读取器
        FileReader fileReader = new FileReader(path);

        // 创建gson对象
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = builder.create();

        // 读取配置文件
        settings = gson.fromJson(fileReader.readString() , settings.getClass());

        // 读取ssh key
        fileReader = new FileReader("/shh.key");
        String sshKey = fileReader.readString();
        settings.setGithubSSHKey(sshKey);
    }
}
