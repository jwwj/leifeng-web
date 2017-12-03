package com.leifeng.bean;
 
import java.util.*;
import javax.servlet.http.*;
 
public class TokenGen {
    private static TokenGen instance = new TokenGen();
 
    private TokenGen() {}
 
    public static TokenGen getInstance() {
        return instance;
    }
 
    public synchronized boolean isTokenValid(HttpServletRequest request) {
        // û��session,��Ϊ�Ƿ�
        HttpSession session = request.getSession(false);
        if (session == null)
            return false;
 
        // session�в���token,
        // ˵��form���ύ����ִ����resetToken()�����token
        // ��Ϊ�Ƿ�
        String stoken = (String) session.getAttribute("token");
        if (stoken == null)
            return false;
 
        // request��������в���token,
        // ��Ϊ�Ƿ�
        String rtoken = request.getParameter("token");
        if (rtoken == null)
            return false;
 
        // request�����е�token��session�б����token����,��Ϊ�Ƿ�
        return stoken.equals(rtoken);
    }
     
    /*
     * ��������token����ҳ�汻����󣬽�session�е�token����ȥ��
     */
    public synchronized void resetToken(HttpServletRequest request)
    {
        HttpSession session = request.getSession(false);
        if (session!=null)
        {
            session.removeAttribute("token");
        }
    }
    /*
     * Ϊ�����½�һ��token��ǣ��˱����һ�������double��toString�γɣ������ַ�ֵ����session��
     */
     
    public synchronized void saveToken(HttpServletRequest request)
    {
        HttpSession session = request.getSession(true);
        Random rand = new Random();
        Double d = rand.nextDouble();
        session.setAttribute("token", d.toString());   
    }
}