package org.libraframework.plugin.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * Created by titengjiang on 2017/9/14.
 */
public class MybatisGeneratorPlugin implements Plugin<Project> {

    public static final String EXTENSION_NAME = "mybatisGenerator";

    public static final String TASK_NAME = "generateMybatis";

    @Override
    public void apply(Project project) {
        project.getExtensions().create(EXTENSION_NAME, MybatisGeneratorExtension.class);
        project.getTasks().create(TASK_NAME, MybatisGeneratorTask.class);
    }

}
