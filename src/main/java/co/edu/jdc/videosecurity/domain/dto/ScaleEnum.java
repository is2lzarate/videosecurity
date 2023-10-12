package co.edu.jdc.videosecurity.domain.dto;

import lombok.Getter;

@Getter
public enum ScaleEnum {
    CELSIUS(-273.15, 100.0), FAHRENHEIT(-459.67, 212.0), KELVIN(0.00, 373.15);
    private Double absoluteZero;
    private Double boilingWater;
    private ScaleEnum(Double absoluteZero, Double boilingWater) {
        this.absoluteZero = absoluteZero;
        this.boilingWater = boilingWater;
    }
}
