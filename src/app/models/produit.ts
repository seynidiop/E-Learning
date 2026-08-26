export interface Produit {
  id: number;
  name: string;
  description: string;
  category:string;
  price: number;
  onSalePrice?: number;
//  photo?: string;
}