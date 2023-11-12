package edu.project3.models;

import java.time.OffsetDateTime;

public record Log(String remoteAddress, String remoteUser, OffsetDateTime time, Request request, Response response, String refer) {
}
