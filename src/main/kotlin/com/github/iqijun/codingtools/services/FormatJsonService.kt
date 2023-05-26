package com.github.iqijun.codingtools.services

import com.google.gson.GsonBuilder
import com.google.gson.ToNumberStrategy
import com.intellij.openapi.components.Service
import com.intellij.openapi.project.Project

@Service(Service.Level.PROJECT)
class FormatJsonService(project : Project) {

        init {
            println("init FormatJsonService")
        }

        fun formatJson(json : String) : String {
            println("json====>$json")
            val gson = GsonBuilder().setPrettyPrinting().create()
            val jsonObj = gson.fromJson(json, Any::class.java)
            var format = gson.toJson(jsonObj);
            println("format"+ format)
            return format;
        }


        fun compressJson(json : String) : String {
            val gson = GsonBuilder().create()
            val jsonObj = gson.fromJson(json, Any::class.java)
            return gson.toJson(jsonObj);
        }

}

