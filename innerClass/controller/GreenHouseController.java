/**
 * @Author: fengsc
 * @Date: 2022-03-31 21:52:44
 * @LastEditTime: 2022-04-01 08:53:16
 */
package controller;

public class GreenHouseController {
    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        // Instead of using code, you could parse
        // configuration information from a text file:
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThermostatDay(1400)
        };
        gc.addEvent(gc.new Restart(2000, eventList));
        gc.addEvent(
                new GreenhouseControls.Terminate(5000));
        gc.run();
    }
}
// Thermostat on night setting //0
// Light is on
// Light is off
// Greenhouse water is on
// Greenhouse water is off
// Bing! //900
// Thermostat on day setting
// Bing!
// Restarting system //2000
// Thermostat on night setting
// Light is on
// Light is off
// Greenhouse water is on
// Bing!
// Greenhouse water is off
// Thermostat on day setting
// Bing!
// Restarting system
// Thermostat on night setting
// Light is on
// Light is off
// Bing!
// Greenhouse water is on
// Greenhouse water is off
// Terminating //5000
