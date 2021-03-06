/* B50_ZK_460Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_ZK_460Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """

			<zk>
				<div>Click on the up/down button of Spinner/Timebox. 
				The value should NOT be shown immediately on the right. 
				(i.e. onChange shall NOT be fire upon clicking on up/down button.)</div>
				<listbox width="350px">
					<listitem>
						<listcell>
							<spinner onChange='lc1.label = event.value' />
						</listcell>
						<listcell id="lc1" />
					</listitem>
					<listitem>
						<listcell>
							<timebox onChange='lc2.label = event.value' />
						</listcell>
						<listcell id="lc2" />
					</listitem>
				</listbox>
			</zk>

		"""
    val ztl$engine = engine()
    val lc1 = ztl$engine.$f("lc1")
    val lc2 = ztl$engine.$f("lc2")
    runZTL(zscript, () => {
      click(jq(".z-spinner").toWidget().$n("btn-up"))
      waitResponse()
      verifyEquals(jq(lc1).`val`(), "")
      click(jq(".z-spinner").toWidget().$n("btn-down"))
      waitResponse()
      verifyEquals(jq(lc1).`val`(), "")
      click(jq(".z-timebox").toWidget().$n("btn-up"))
      waitResponse()
      click(jq(".z-timebox").toWidget().$n("btn-up"))
      waitResponse()
      verifyEquals(jq(lc2).`val`(), "")
      click(jq(".z-timebox").toWidget().$n("btn-down"))
      waitResponse()
      verifyEquals(jq(lc2).`val`(), "")
    })
  }
}



