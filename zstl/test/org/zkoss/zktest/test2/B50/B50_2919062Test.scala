/* B50_2919062Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_2919062Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<zk>
Please type "-0" into the inputbox, and then click outside of it, you should not see any error message.
<separator/>
<intbox constraint="no negative"/>
</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      typeKeys(jq("@intbox"), "-0");
      waitResponse();
      blur(jq("@intbox"));
      waitResponse()
      verifyFalse(jq(".z-errorbox").exists());
    })
  }
}


