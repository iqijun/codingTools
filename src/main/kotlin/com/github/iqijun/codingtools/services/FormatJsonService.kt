package com.github.iqijun.codingtools.services

import com.google.gson.GsonBuilder
import com.google.gson.ToNumberStrategy
import com.intellij.openapi.components.Service
import com.intellij.openapi.project.Project
import java.awt.Toolkit

@Service(Service.Level.PROJECT)
class FormatJsonService(project : Project) {

        init {
            println("init FormatJsonService")
        }

        fun formatJson(json : String) : String {
            // if json is empty return empty string
            if (json.isEmpty()) {
                return ""
            }
            val gson = GsonBuilder().setPrettyPrinting().create()
            val jsonObj = gson.fromJson(json, Any::class.java)
            val format = gson.toJson(jsonObj);
            return format;
        }


        fun compressJson(json : String) : String {
            if (json.isEmpty()) {
                return ""
            }
            val gson = GsonBuilder().create()
            val jsonObj = gson.fromJson(json, Any::class.java)
            return gson.toJson(jsonObj);
        }

       fun copyResult(result : String) {
           Toolkit.getDefaultToolkit().systemClipboard.setContents(java.awt.datatransfer.StringSelection(result), null)
        }

}

