package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Grid_Paging_Default_Top_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<grid id="grid" mold="paging" pageSize="3">
		<columns>
			<column label="Index"/>
			<column label="Head 1"/>
			<column label="Head 2" align="center"/>
			<column label="Head 3" align="right"/>
		</columns>
		<rows>
			<row>
				1
				<listbox mold="select">
					<listitem label="AB"/>
					<listitem label="CD"/>
				</listbox>
				<datebox/>
				<textbox rows="3"/>
			</row>
			<row>
				2
				<label value="A11"/>
				<label value="A12"/>
				<label value="A13"/>
			</row>
			<row>
				3
				<checkbox checked="true" label="Option 1"/>
				<checkbox label="Option 2"/>
				<radiogroup>
					<radio label="Apple"/>
					<radio label="Orange" checked="true"/>
					<radio label="Lemon"/>
				</radiogroup>
			</row>
			<row>
				4
				<checkbox checked="true" label="Option 1"/>
				<checkbox label="Option 2"/>
				<radiogroup orient="vertical">
					<radio label="Apple"/>
					<radio label="Orange" checked="true"/>
					<radio label="Lemon"/>
				</radiogroup>
			</row>
			<row>
				5
				<listbox mold="select">
					<listitem label="AB"/>
					<listitem label="CD"/>
				</listbox>
				<datebox/>
				<textbox rows="3"/>
			</row>
			<row>
				6
				<label value="A11"/>
				<label value="A12"/>
				<label value="A13"/>
			</row>
			<row>
				7
				<checkbox checked="true" label="Option 1"/>
				<checkbox label="Option 2"/>
				<radiogroup>
					<radio label="Apple"/>
					<radio label="Orange" checked="true"/>
					<radio label="Lemon"/>
				</radiogroup>
			</row>
			<row>
				8
				<checkbox checked="true" label="Option 1"/>
				<checkbox label="Option 2"/>
				<radiogroup orient="vertical">
					<radio label="Apple"/>
					<radio label="Orange" checked="true"/>
					<radio label="Lemon"/>
				</radiogroup>
			</row>
		</rows>
	</grid>
	
	<zscript>
		grid.setPagingPosition("top");
		grid.getPagingChild().setMold("default");
	</zscript>
</zk>
			
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
