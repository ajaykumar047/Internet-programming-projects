<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
    <h2>Title that contains XSLT</h2>
    <table border="1">
      <tr bgcolor="#9acd32">
        <th>Title</th>
      </tr>
      <xsl:for-each select="bib/book[contains(title, 'XSLT')]">
        <tr>
          <td><xsl:value-of select="title"/></td>
        </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>