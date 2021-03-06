/* 

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.bind.basic
import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.ClientWidget

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_FormDirtyTest extends ZTL4ScalaTestCase {
  @Test
  def testArg() = {
    val zul = """
      <include src="/bind/basic/form-dirty.zul"/>
"""

    runZTL(zul, () => {
      def `type` = (n: ClientWidget, input: String) => {
    	n.toElement().set("value", "")
        sendKeys(n, input)
    	waitResponse()
    	blur(n)
      }
      
      verifyEquals("false", jq("$dirty").toWidget().attr("value"))
      verifyEquals("Dennis", jq("$l1").toWidget().attr("value"))
      
      `type`(jq("$t1").toWidget(), "X")
      waitResponse()
      verifyEquals("true", jq("$dirty").toWidget().attr("value"))
      verifyEquals("X", jq("$l1").toWidget().attr("value"))
      
      `type`(jq("$t1").toWidget(), "Dennis")
      waitResponse()
      // since ZK 8.0.2, once the value changed, it would become dirty.
      verifyEquals("true", jq("$dirty").toWidget().attr("value"))
      verifyEquals("Dennis", jq("$l1").toWidget().attr("value"))
      
      `type`(jq("$t1").toWidget(), "Y")
      waitResponse()
      verifyEquals("true", jq("$dirty").toWidget().attr("value"))
      verifyEquals("Y", jq("$l1").toWidget().attr("value"))
      
      click(jq("$btn2").toWidget())
      waitResponse()
      verifyEquals("old-name Dennis", jq("$msg").toWidget().attr("value"))
      
      click(jq("$btn1").toWidget())
      waitResponse()
      verifyEquals("saved Y", jq("$msg").toWidget().attr("value"))
      
      click(jq("$btn2").toWidget())
      waitResponse()
      verifyEquals("old-name Y", jq("$msg").toWidget().attr("value"))
      verifyEquals("false", jq("$dirty").toWidget().attr("value"))
      verifyEquals("Y", jq("$l1").toWidget().attr("value"))
    })
  }
}