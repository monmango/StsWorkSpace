/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.41
 * Generated at: 2019-09-27 06:43:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE >\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<footer class=\"bg-191 color-ash pt-50 pb-20 text-left center-sm-text\">\r\n");
      out.write("\r\n");
      out.write("      <div class=\"container-fluid\" style=\"height:50%\">\r\n");
      out.write("         <div class=\"row\" style=\"height:200px!important\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-lg-1\"></div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-md-4 col-lg-6 mb-30\">\r\n");
      out.write("               <div class=\"card h-100\">\r\n");
      out.write("                  <div class=\"dplay-tbl\">\r\n");
      out.write("                     <div class=\"dplay-tbl-cell\">\r\n");
      out.write("\r\n");
      out.write("                        \r\n");
      out.write("                        <p class=\"color-ash mt-25\">\r\n");
      out.write("                           <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\r\n");
      out.write("                           Copyright &copy;\r\n");
      out.write("                           <script>\r\n");
      out.write("                              document\r\n");
      out.write("                                    .write(new Date().getFullYear());\r\n");
      out.write("                           </script>\r\n");
      out.write("                           All rights reserved | This template is made with <i\r\n");
      out.write("                              class=\"ion-heart\" aria-hidden=\"true\"></i> by <a\r\n");
      out.write("                              href=\"https://colorlib.com\" target=\"_blank\">Colorlib</a>\r\n");
      out.write("                           <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\r\n");
      out.write("                        </p>\r\n");
      out.write("\r\n");
      out.write("                     </div>\r\n");
      out.write("                     <!-- dplay-tbl-cell -->\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <!-- dplay-tbl -->\r\n");
      out.write("               </div>\r\n");
      out.write("               <!-- card -->\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- col-lg-4 col-md-6 -->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-md-4 col-lg-2 mb-30\">\r\n");
      out.write("               <div class=\"card h-100\">\r\n");
      out.write("                  <div class=\"dplay-tbl\">\r\n");
      out.write("                     <div class=\"dplay-tbl-cell\">\r\n");
      out.write("\r\n");
      out.write("                        <ul class=\"list-a-plr-10\">\r\n");
      out.write("                           <li><a href=\"https://www.facebook.com/\"><i class=\"ion-social-facebook\"></i></a></li>\r\n");
      out.write("                           <li><a href=\"https://twitter.com\"><i class=\"ion-social-twitter\"></i></a></li>\r\n");
      out.write("                           <li><a href=\"https://www.youtube.com/\"><i class=\"ion-social-youtube\"></i></a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("\r\n");
      out.write("                     </div>\r\n");
      out.write("                     <!-- dplay-tbl-cell -->\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <!-- dplay-tbl -->\r\n");
      out.write("               </div>\r\n");
      out.write("               <!-- card -->\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- col-lg-4 col-md-6 -->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-md-4 col-lg-2 mb-30 text-left\">\r\n");
      out.write("               <div class=\"card h-100\">\r\n");
      out.write("                  <div class=\"dplay-tbl\">\r\n");
      out.write("                     <div class=\"dplay-tbl-cell\">\r\n");
      out.write("                        <form class=\"form-block form-brdr-b mx-w-400x m-auto\">\r\n");
      out.write("                           <span class=\"color-white ptb-15 center-sm-text\" style=\"color:white\">gofarm16@gmail.com </span>\r\n");
      out.write("                           <span class=\"mt-30 btn-brdr-grey color-ash w-100 text-center\">Go Farm</span>\r\n");
      out.write("\r\n");
      out.write("                        </form>\r\n");
      out.write("                     </div>\r\n");
      out.write("                     <!-- dplay-tbl-cell -->\r\n");
      out.write("                  </div>\r\n");
      out.write("                  <!-- dplay-tbl -->\r\n");
      out.write("               </div>\r\n");
      out.write("               <!-- card -->\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- col-lg-4 col-md-6 -->\r\n");
      out.write("\r\n");
      out.write("         </div>\r\n");
      out.write("         <!-- row -->\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- container -->\r\n");
      out.write("   </footer>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
