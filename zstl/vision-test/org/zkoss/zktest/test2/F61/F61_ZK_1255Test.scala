package org.zkoss.zktest.test2.F61

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "F61-ZK-1255.zul")
class F61_ZK_1255Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?page title="F61-ZK-1255" contentType="text/html;charset=UTF-8"?>
<window
	title="HTML5 Placeholder Support"
	border="normal"
	width="500px">
	<panel
		title="Instruction"
		border="normal">
		<panelchildren>
			<html>
				<p>
					Below is a demonstration of the input elements that support HTML5 placeholder
					attribute.
				</p>

				<p>
					If this page is viewed on HTML5 supporting browsers, a hint text is displayed
					inside the input area while	the input value is empty. 
				</p>
					
				<p>
					Since spinner and doublespinner already have non-empty initial values,	the hint
					text would not be shown at the beginning. However, once the value is deleted, the
					hint text would appear.
				</p>
			</html>
		</panelchildren>
	</panel>

	<separator />

	<vlayout>
		<hlayout>
		<button label="Set Placeholder">
			<attribute name="onClick">
			<![CDATA[
			txtBox.setPlaceholder("This \"placeholder\" is dynamically generated.");
			]]>
       		</attribute>
		</button>
		<button label="Clear Placeholder">
			<attribute name="onClick">
			<![CDATA[
			txtBox.setPlaceholder(null);
			]]>
       		</attribute>
		</button>
		</hlayout>
		
		<textbox
			id="txtBox"
			cols="50" />
	</vlayout>

	<separator />

	<grid>
		<columns>
			<column label="Input Type" hflex="min" />
			<column label="Demo" />
		</columns>
		<rows>
			<row>
				<label value="Textbox" />
				<textbox placeholder="Please type some text" />
			</row>
			<row>
				<label value="Multiline Textbox" />
				<textbox
					multiline="true"
					rows="3"
					cols="50"
					placeholder="Please type some text" />
			</row>
			<row>
				<label value="Datebox" />
				<datebox placeholder="Birthday" />
			</row>
			<row>
				<label value="Timebox" />
				<timebox placeholder="Start time" width="100px" 	/>
			</row>
			<row>
				<label value="Intbox" />
				<intbox constraint="no negative" placeholder="non-negative please" />
			</row>
			<row>
				<label value="Longbox" />
				<longbox format="#,##0" placeholder="-999~999" />
			</row>
			<row>
				<label value="Decimalbox" />
				<decimalbox placeholder="Decimal box" />
			</row>
			<row>
				<label value="Doublebox" />
				<doublebox placeholder="Double box" />
			</row>
			<row>
				<label value="Spinner" />
				<spinner placeholder="Spinner" />
			</row>
			<row>
				<label value="Doublespinner" />
				<doublespinner placeholder="Double Spinner" />
			</row>
		</rows>
	</grid>
</window>
"""  
  runZTL(zscript,
    () => {
      verifyImage()
      click(jq(".z-button:contains(Set)"))
      waitResponse()
      verifyImage()
      click(jq(".z-button:contains(Clear)"))
      waitResponse()
      verifyImage()
    })
    
  }
}