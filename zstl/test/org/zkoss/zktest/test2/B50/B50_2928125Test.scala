/* B50_2928125Test.java

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
import org.zkoss.ztl.unit.Widget


class B50_2928125Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<window>
	<html><![CDATA[
	<ul>
		<li>Click the add/remove button first, and then click the test button.
		You shall see a modal window.</li>
		<li>Then, do it again. You shall see nothing</li>
	</ul>
	]]></html>
	<zscript>
	EventListener listener;
	</zscript>
	<button label="add/remove listener">
		<attribute name="onClick"><![CDATA[
	if (listener != null) {
		target.removeEventListener("onClick", listener);
		listener = null;
	} else {
		target.addEventListener("onClick", listener = new EventListener() {
			public void onEvent(Event evt) {
				alert("listener added");
			}
		});
	}
		]]></attribute>
	</button>
	<button id="target" label="test"/>
</window>
			"""
    val ztl$engine = engine()
    val target = ztl$engine.$f("target")
    runZTL(zscript, () => {
      click(jq("@button[label=\"add/remove listener\"]"))
      waitResponse()
      click(jq("$target"))
      waitResponse()
      verifyTrue(jq("$btn1").exists())
      click(jq("$btn1"))
      waitResponse()
      click(jq("@button[label=\"add/remove listener\"]"))
      waitResponse()
      click(jq("$target"))
      waitResponse()
      verifyFalse(jq("$btn1").exists());
    })
  }
}



