import { computed, Injectable, signal } from '@angular/core';
import { Produit } from '../models/produit';
import { CartItem } from '../models/cart-item';

@Injectable({
  providedIn: 'root',
})
export class CartService {
  
  protected cartItems= signal<CartItem[]>([]);
  
  readonly totalItems= computed(() => this.cartItems().reduce((total, item) => total + item.quantity, 0));

  addToCart(produit: Produit): void {
  this.cartItems.update((items) => {

    const existingItem = items.find(
      (item): boolean => item.produit.id === produit.id
    );

    if (existingItem) {
      return items.map((item) =>
        item.produit.id === produit.id
          ? { ...item, quantity: item.quantity + 1 }
          : item
      );
    }

    return [...items, { produit, quantity: 1 }];
  });
}



}
