import { Publish } from './Publish';
import { Video } from './Video';

export class User {
  public idUser: number;
  public nome: string;
  public email: string;
  public senha: string;
  public tipo: string;
  public foto: string;
  public meusBoletins: Publish;
  public meusVideos: Video;
}
