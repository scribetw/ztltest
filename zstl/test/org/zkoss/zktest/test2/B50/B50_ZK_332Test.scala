/* B50_ZK_332Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Oct 11, 2011 18:15:14 PM , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-332
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-ZK-332.zul,A,E,Tree,disabled,open")
class B50_ZK_332Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      var tree: Widget = engine.$f("tree")
      var tr: Widget = engine.$f("tr")
      waitResponse()
      click(jq(tr.$n("open")))
      waitResponse()
      verifyEquals(2, jq(tree.$n("rows")).find(".z-treerow").length())
      click(jq(tr.$n("open")))
      waitResponse()
      verifyEquals("", jq(tree.$n("rows")).find(".z-treerow").get(2).attr("style.display"))
      verifyEquals("", jq(tree.$n("rows")).find(".z-treerow").get(3).attr("style.display"))
    })
  }
}