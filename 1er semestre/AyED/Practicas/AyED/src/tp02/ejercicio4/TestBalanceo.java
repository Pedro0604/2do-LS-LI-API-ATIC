package tp02.ejercicio4;

import tp02.ejercicio3.PilaGenerica;

public class TestBalanceo {
	public static boolean isBalanced(String st) {
		if (st.equals(""))
			return true;
		PilaGenerica<String> p = new PilaGenerica<>();
		String[] stArr = st.split("");
		for (String s : stArr) {
			if (s.equals("(") || s.equals("{") || s.equals("[")) {
				p.apilar(s);
			} else {
				if (p.esVacia())
					return false;
				if (s.equals(")")) {
					if (!p.desapilar().equals("("))
						return false;
				} else {
					if (s.equals("}")) {
						if (!p.desapilar().equals("{"))
							return false;
					} else {
						if (s.equals("]")) {
							if (!p.desapilar().equals("["))
								return false;
						}
					}
				}
			}
		}
		return p.esVacia();
	}
}
