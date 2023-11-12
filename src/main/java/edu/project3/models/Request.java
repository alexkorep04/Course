package edu.project3.models;

public record Request(String method, String resource, String protocol, String user) {
}
