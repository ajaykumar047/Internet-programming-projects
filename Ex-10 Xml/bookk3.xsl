<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
    <h2>Result</h2>
    <table border="1">
      <tr bgcolor="#9acd32">
        <th>Result</th>
        
      </tr>
      <xsl:for-each select="bib/book[author]">
        <tr rowspan="2">
          <td><xsl:value-of select="title"/></td>
          <td><xsl:value-of select="author"/></td>
        </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>