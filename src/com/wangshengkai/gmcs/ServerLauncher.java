package com.wangshengkai.gmcs;

import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.RuntimeUtil;

/**
 * @author wsk2007
 * 本类负责使用命令行启动服务端并监听服务端状态，控制服务端
 */
public class ServerLauncher {
    private Settings settings;

    private DataPrinter printer;

    private Process p;

    /**
     * 构造方法
     * @param settings 服务器配置文件
     */
    public ServerLauncher(Settings settings){
        this.settings = settings;
    }

    /**
     * 配置环境
     */
    public void prepareEnvironment(){
        Console.print(RuntimeUtil.execForStr("apt install git"));
        Console.print(RuntimeUtil.execForStr("apt install openjdk-8-jdk"));
        FileWriter writer = new FileWriter("~/.ssh");
        writer.write(settings.getGithubSSHKey());
        Console.print(RuntimeUtil.execForStr("git config --global user.name \"" + settings.getGithubUserName() + "\""));
        Console.print(RuntimeUtil.execForStr("git config --global user.name \"" + settings.getGithubEmail() + "\""));
        Console.print(RuntimeUtil.execForStr("cd /opt"));
        Console.print(RuntimeUtil.execForStr("git clone https://github.com/" + settings.getGithubUserName() + "/" + settings.getDataRepoName() + ".git"));
    }

    /**
     * 启动服务器
     */
    public void launchServer(){
        Console.print(RuntimeUtil.execForStr("cd /opt/" + settings.getDataRepoName() + "/"));
        p = RuntimeUtil.exec("java -jar " + settings.getServerJarName());
        printer = new DataPrinter(p.getInputStream() , p.getErrorStream());
        printer.start();
    }

    /**
     * 关闭服务器
     */
    public void stopServer() {

    }

    /**
     * 执行指令
     * @param command 指令
     */
    public void executeCommand(String command) {

    }
}
