<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
    <h2>Books by Adddsion Wesley</h2>
    <table border="1">
      <tr bgcolor="#9acd32">
        <th>Title</th>
        <th>Year</th>
      </tr>
      <xsl:for-each select="bib/book[publisher='Addison-Wesley']">
        <tr>
          <td><xsl:value-of select="title"/></td>
          <td><xsl:value-of select="@year"/></td>
        </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>