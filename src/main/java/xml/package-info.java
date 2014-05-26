/**
 * A Snake játék xml feldolgozója. 
 * A csomag célja, hogy {@link Map} objektumot hozzunk létre XML fájlból.
 * 
 * <pre>
 * Map map;
 * map=XmlParser.mapFromXmlFile("A fájl elérési útja");
 * </pre>
 * 
 * Egy megfelelő XML fájl:
 * 
 * <pre>
 * &lt;Map width="800" height="800"&gt;
    &lt;Snakes&gt;        
        &lt;Snake&gt;
	    &lt;Position&gt;
                &lt;X&gt;50&lt;/X&gt;
                &lt;Y&gt;50&lt;/Y&gt;    
            &lt;/Position&gt;
            &lt;Velocity&gt;
                &lt;X&gt;10&lt;/X&gt;
                &lt;Y&gt;10&lt;/Y&gt;
            &lt;/Velocity&gt;
            &lt;Thickness&gt;5&lt;/Thickness&gt;
            &lt;TurnSpeed&gt;90&lt;/TurnSpeed&gt;
	    &lt;Color&gt;
                &lt;Red&gt;100&lt;/Red&gt;
                &lt;Green&gt;100&lt;/Green&gt;
                &lt;Blue&gt;100&lt;/Blue&gt;
            &lt;/Color&gt;
        &lt;/Snake&gt;
        &lt;Snake&gt;
	    &lt;Position&gt;
                &lt;X&gt;300&lt;/X&gt;
                &lt;Y&gt;50&lt;/Y&gt;    
            &lt;/Position&gt;
            &lt;Velocity&gt;
                &lt;X&gt;10&lt;/X&gt;
                &lt;Y&gt;10&lt;/Y&gt;
            &lt;/Velocity&gt;
            &lt;Thickness&gt;5&lt;/Thickness&gt;
            &lt;TurnSpeed&gt;90&lt;/TurnSpeed&gt;
	    &lt;Color&gt;
                &lt;Red&gt;100&lt;/Red&gt;
                &lt;Green&gt;100&lt;/Green&gt;
                &lt;Blue&gt;100&lt;/Blue&gt;
            &lt;/Color&gt;
        &lt;/Snake&gt;
    &lt;/Snakes&gt;
&lt;/Map&gt;
 * </pre>
 */
package xml;
