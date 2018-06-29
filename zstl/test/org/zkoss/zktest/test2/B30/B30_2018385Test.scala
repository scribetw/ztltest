/* B30_2018385Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B30_2018385Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<?page id="testZul" title=" New ZUL Title" cacheable="false" 
	language="xul/html" zscriptLanguage="Java" contentType="text/html;charset=UTF-8"?>
<zk>
<html><![CDATA[
1. You should see listbox with item0 ~ item19.<br/>
2. Press buton "change 1st item" and you should see the 1st item is changed from "item0" to "new item0".<br/>
3. Done.<br/>
]]></html>
<window>
<zscript><![CDATA[
List lst = new ArrayList(20);
ListModel model = new ListModelList(lst, true);
for(int j = 0; j < 20; ++j) {
lst.add("item"+ j);
}
]]></zscript>
<listbox model="${model}" rows="10"/>
<button label="change 1st item" onClick='Iterator it = model.listIterator(0);
it.next(); it.set("new item0")'/>
</window>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val testZul = ztl$engine.$f("testZul")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      verifyEquals("new item0", jq("@listitem:first").text())
    })
  }
}


