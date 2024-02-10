package com.umlaut.crowd.internal;

import java.text.ParseException;
import java.util.Map;
import java.util.Set;

public class m8 implements d8 {
    public u6 a(wb wbVar, d8 d8Var) throws ParseException {
        if (wbVar == null) {
            throw new ParseException("Token is null", -1);
        } else if (wbVar.h().equals("TRUE")) {
            return new u6(this, wbVar);
        } else {
            throw new ParseException("Wrong RuleAst selected", wbVar.f());
        }
    }

    public Set<String> a(Set<String> set) {
        return set;
    }

    public boolean a(Map<String, String> map) {
        return true;
    }
}
