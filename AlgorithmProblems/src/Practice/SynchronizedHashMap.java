package Practice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchronizedHashMap {

	/*{@link Collections#synchronizedMap Collections.synchronizedMap}
	 * method.  This is best done at creation time, to prevent accidental
	 * unsynchronized access to the map:<pre>
	 *   Map m = Collections.synchronizedMap(new HashMap(...));</pre>
	 */
	
Map m = Collections.synchronizedMap(new HashMap<>());

}
