package com.artists

import org.gradle.api.Plugin
import org.gradle.api.Project

class BuildSrcPlugin2 implements Plugin<Project>{
    @Override
    void apply(Project project) {
        // This name can't include _ e.g. Custom_Plugin
        project.task("globalPlugin2"){
            doLast{
                println("This is global custom plugin can use in any project!")
            }
        }
    }
}
