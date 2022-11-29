package com.miTienda.CarritoCompra;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.miTienda.Articles.Articles;




public class Carrito {
	
	private List<itemCarrito> listCarrito=new ArrayList<itemCarrito>();

	public Carrito(List<itemCarrito> listCarrito) {
		super();
		this.listCarrito = listCarrito;
	}
	
	public Carrito() {
		super();
	}

	public List<itemCarrito> getListCarrito() {
		return listCarrito;
	}

	public void setListCarrito(List<itemCarrito> listCarrito) {
		this.listCarrito = listCarrito;
	}
	
	public List<itemCarrito> vaciarLista() {
		listCarrito.clear();
		return listCarrito;
	}

	@Override
	public int hashCode() {
		return Objects.hash(listCarrito);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrito other = (Carrito) obj;
		return Objects.equals(listCarrito, other.listCarrito);
	}

	@Override
	public String toString() {
		return "Carrito [listCarrito=" + listCarrito + "]";
	}
	
	public void addItemCarrito(itemCarrito a) {
		if(!listCarrito.contains(a)) {
			listCarrito.add(a);
		}else {
			System.out.println("El carrito ya existe");
		}
	}
	
	public void deleteItemCarrito(itemCarrito b) {
		if(listCarrito.contains(b) || listCarrito.isEmpty()) {
			System.out.println("El carrito no contiene este objeto");
		}else {
			listCarrito.remove(b);	
		}
		
	}
	
	public int getCantidadTotal() {
		return listCarrito.size();
	}
	
	public void updateItemCarrito(itemCarrito c) {
		for (itemCarrito a: listCarrito) {
			if(a.equals(c)) {
				int cantidad=c.getQuantity();
				a.setQuantity(cantidad);
			}
		}
	}
	

}
