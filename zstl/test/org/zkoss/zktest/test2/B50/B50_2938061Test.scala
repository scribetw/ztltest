/* B50_2938061Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl.util._

class B50_2938061Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<zk>
				    Please select a comboitem, then the background of the combobox should be changed.
				    <combobox id="c" onSelect="setColor()" style="background: violet;">
				        <comboitem label="Comboitem 1" />
				        <comboitem label="Comboitem 2" />
				        <comboitem label="Comboitem 3" />
				    </combobox>
				    <zscript>
				        <![CDATA[
				            void setColor() {
								if (c.getSelectedIndex() == 1) c.setStyle("background: blue;");
								else if (c.getSelectedIndex() == 2) c.setStyle("background: red;");
								else c.setStyle("background: green;");
							}
				        ]]>
				    </zscript>
				</zk>
			"""
    val ztl$engine = engine()
    val c = ztl$engine.$f("c")
    runZTL(zscript, () => {
      click(c.$n("btn"))
      waitResponse()
      click(jq(".z-comboitem:eq(0)"))
      waitResponse()
      verifyEqualColor("green", jq(c).css("backgroundColor"))
      click(c.$n("btn"))
      waitResponse()
      click(jq(".z-comboitem:eq(1)"))
      waitResponse()
      verifyEqualColor("blue", jq(c).css("backgroundColor"))
      click(c.$n("btn"))
      waitResponse()
      click(jq(".z-comboitem:eq(2)"))
      waitResponse()
      verifyEqualColor("red", jq(c).css("backgroundColor"))
    })
  }
}



