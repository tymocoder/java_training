package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

// @Getter generates getter methods at compile time
// @Setter generates setter methods at compile time
// @Accessors(chain = true) enables fluent API for the class - style that allows to chain calls because setters return "this"
@Getter
@Setter
@Accessors(chain = true)
public class Configuration {
    private String host;
    private int port;
    private boolean secure;
}
