package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Grid_Sort_Dsc_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<zscript>
	import java.util.*;
	import org.zkoss.zkdemo.userguide.Comparators;
	
	Comparator asc = Comparators.ascRowDetailComparator;
	Comparator dsc = Comparators.dscRowDetailComparator;
	</zscript>

	<grid>
		<columns menupopup="auto">
			<column id="sortColumn" label="Author" sortAscending="${asc}" sortDescending="${dsc}"/>
			<column label="Title" sort="auto" />
			<column label="Publisher"/>
			<column label="Hardcover"/>
		</columns>
		<rows>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
		</rows>
	</grid>
	
	<zscript>
	sortColumn.sort(false);
	</zscript>
</zk>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
