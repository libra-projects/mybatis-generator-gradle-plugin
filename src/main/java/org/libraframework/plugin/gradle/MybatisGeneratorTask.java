package org.libraframework.plugin.gradle;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by titengjiang on 2017/9/14.
 */
public class MybatisGeneratorTask extends DefaultTask {

    private String generatorXMLPath;

    public String getGeneratorXMLPath() {
        return generatorXMLPath;
    }

    public void setGeneratorXMLPath(String generatorXMLPath) {
        this.generatorXMLPath = generatorXMLPath;
    }

    @TaskAction
    void start() {
        MybatisGeneratorExtension extension = (MybatisGeneratorExtension)getProject().getExtensions().getByName(MybatisGeneratorPlugin.EXTENSION_NAME);
        String generatorXMLPath = extension.getGeneratorXMLPath();
        if (generatorXMLPath == null) {
            throw new RuntimeException("Must specialize generatorXMLPath in mybatisGenerator extension");
        }
        File file = new File(generatorXMLPath);
        List<String> warnigs = new ArrayList<>();
        ConfigurationParser configurationParser = new ConfigurationParser(warnigs);
        Configuration configuration = null;
        try {
            configuration = configurationParser.parseConfiguration(file);
            DefaultShellCallback callback = new DefaultShellCallback(true);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, null, warnigs);
            myBatisGenerator.generate(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
