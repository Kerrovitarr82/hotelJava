package com.senla.hoteladmin.controller;

import java.io.IOException;

public interface SerializationController {
    void entitiesSerialization() throws IOException;

    void entitiesDeserialization() throws IOException, ClassNotFoundException;
}
