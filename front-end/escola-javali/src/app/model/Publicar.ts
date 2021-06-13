import { User } from './User';

export class Publicar {
  public idPublicar: number;
  public nomeAluno: string;
  public bimestre1: number;
  public bimestre2: number;
  public bimestre3: number;
  public bimestre4: number;
  public media: number;
  public situacao: string;
  public tituloDoVideo: string;
  public descricaoDoVideo: string;
  public videoAula: string;
  public publicadoPor: User[];
}
