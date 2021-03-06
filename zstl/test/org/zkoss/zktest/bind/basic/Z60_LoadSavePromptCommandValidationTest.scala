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
class Z60_LoadSavePromptCommandValidationTest extends ZTL4ScalaTestCase {
  @Test
  def testArg() = {
    val zul = """ 
      <include src="/bind/basic/load-save-prompt-command-validation.zul" />
"""

    runZTL(zul, () => {
      
      def `type` = (n: ClientWidget, input: String) => {
    	n.toElement().set("value", "")
        sendKeys(n, input)
    	waitResponse()
    	blur(n)
      }
      
      verifyEquals("A", jq("$l11").toWidget().attr("value"))
      verifyEquals("B", jq("$l12").toWidget().attr("value"))
      verifyEquals("C", jq("$l13").toWidget().attr("value"))
      `type`(jq("$t12").toWidget(), "GG")
      waitResponse()
      `type`(jq("$t11").toWidget(), "PP")
      waitResponse()
      verifyEquals("A", jq("$l11").toWidget().attr("value"))
      verifyEquals("B", jq("$l12").toWidget().attr("value"))
      verifyEquals("C", jq("$l13").toWidget().attr("value"))
      verifyEquals("value 1 has to be XX or ZZ", jq("$msg1").toWidget().attr("value"))
      verifyEquals("value 2 has to be YY or ZZ", jq("$msg2").toWidget().attr("value"))
      `type`(jq("$t11").toWidget(), "XX")
      waitResponse()
      verifyEquals("XX", jq("$l11").toWidget().attr("value"))
      verifyEquals("B", jq("$l12").toWidget().attr("value"))
      verifyEquals("C", jq("$l13").toWidget().attr("value"))
      verifyEquals("", jq("$msg1").toWidget().attr("value"))
      verifyEquals("value 2 has to be YY or ZZ", jq("$msg2").toWidget().attr("value"))
      `type`(jq("$t11").toWidget(), "YY")
      waitResponse()
      verifyEquals("XX", jq("$l11").toWidget().attr("value"))
      verifyEquals("YY", jq("$l12").toWidget().attr("value"))
      verifyEquals("GG", jq("$l13").toWidget().attr("value"))
      verifyEquals("doCmd1", jq("$msg1").toWidget().attr("value"))
      verifyEquals("", jq("$msg2").toWidget().attr("value"))
      `type`(jq("$t11").toWidget(), "ZZ")
      waitResponse()
      verifyEquals("ZZ", jq("$l11").toWidget().attr("value"))
      verifyEquals("ZZ", jq("$l12").toWidget().attr("value"))
      verifyEquals("GG", jq("$l13").toWidget().attr("value"))
      verifyEquals("doCmd1", jq("$msg1").toWidget().attr("value"))
      verifyEquals("", jq("$msg2").toWidget().attr("value"))
    })
  }
}