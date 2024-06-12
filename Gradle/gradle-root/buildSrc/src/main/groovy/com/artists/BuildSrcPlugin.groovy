package com.artists

import org.gradle.api.Plugin
import org.gradle.api.Project

class BuildSrcPlugin implements Plugin<Project>{
    @Override
    void apply(Project project) {
        // This name can't include _ e.g. Custom_Plugin
        project.task("globalPlugin"){
            doLast{
                println("This is global custom plugin!")
            }
        }
    }
}
