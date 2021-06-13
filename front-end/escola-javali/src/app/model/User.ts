import { Publicar } from './Publicar';

export class User {
  public idUser: number;
  public nome: string;
  public senha: string;
  public tipo: string;
  public foto: string;
  public meusBoletins: Publicar[];
}
